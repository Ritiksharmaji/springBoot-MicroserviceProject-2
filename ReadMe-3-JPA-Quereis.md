Below is a **complete, clean, structured set of notes on JPA Queries** — perfect for revision, interviews, and real coding.

---

# ✅ **FULL NOTES ON JPA QUERIES (JPQL, Native, Derived Methods, Criteria API)**

JPA provides 4 main ways to write queries:

1️⃣ **Derived Query Methods (Spring Data JPA)**
2️⃣ **JPQL (Java Persistence Query Language)**
3️⃣ **Native SQL Queries**
4️⃣ **Criteria API (Dynamic Queries)**

I’ll explain each with syntax, rules, examples, advantages, and best practices.

---

# ----------------------------------

# ✅ **1. DERIVED QUERY METHODS**

# ----------------------------------

These are auto-generated queries based on method names in a `Repository` interface.

### ✔ You don’t write SQL — Spring generates it.

### 📌 Example Entity

```java
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Double price;
    private String category;
}
```

### ✔ Example Repository (Derived Queries)

```java
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String title);

    List<Product> findByCategoryAndPrice(String category, Double price);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByCategoryOrderByPriceDesc(String category);

    boolean existsByTitle(String title);

    long countByCategory(String category);

    void deleteByTitle(String title);
}
```

---

## ✔ **Rules for Derived Queries**

### **Keywords**

| Keyword                                            | Meaning        |
| -------------------------------------------------- | -------------- |
| `findBy`                                           | select *       |
| `readBy`                                           | same as findBy |
| `getBy`                                            | same           |
| `countBy`                                          | count          |
| `existsBy`                                         | return boolean |
| `deleteBy`                                         | delete rows    |
| `And`, `Or`                                        | conditions     |
| `Between`                                          | range queries  |
| `Like`, `StartingWith`, `EndingWith`, `Containing` | pattern        |
| `OrderBy`                                          | sorting        |
| `In`, `NotIn`                                      | list           |

### ✔ Example

`findByPriceBetween(100, 500)`

Generates SQL:

```sql
select * from product where price between 100 and 500;
```

---

# ----------------------------------

# ✅ **2. JPQL (Java Persistence Query Language)**

# ----------------------------------

### ✔ JPQL looks like SQL but works on **Entity names**, not tables.

### ❌ WRONG (table)

```sql
select * from product;
```

### ✔ RIGHT (entity)

```java
@Query("select p from Product p where p.category = ?1")
List<Product> findProducts(String category);
```

---

# ✔ **JPQL Examples**

### **Basic Select**

```java
@Query("select p from Product p")
List<Product> getAllProducts();
```

### **Where Clause**

```java
@Query("select p from Product p where p.price > :price")
List<Product> findExpensive(@Param("price") Double price);
```

### **AND / OR**

```java
@Query("select p from Product p where p.category = ?1 and p.price < ?2")
List<Product> search(String category, Double price);
```

### **Like**

```java
@Query("select p from Product p where p.title like %:keyword%")
List<Product> searchByTitle(String keyword);
```

### **Order By**

```java
@Query("select p from Product p order by p.price desc")
List<Product> sortProducts();
```

---

## ✔ **JOIN in JPQL**

Assume:

```
Product -- ManyToOne --> Category
```

### INNER JOIN

```java
@Query("select p from Product p join p.category c where c.name = :name")
List<Product> findByCategoryName(String name);
```

### LEFT JOIN

```java
@Query("select p from Product p left join p.category c")
List<Product> withOrWithoutCategory();
```

---

# ----------------------------------

# ✅ **3. NATIVE SQL QUERIES**

# ----------------------------------

Use when:

✔ Need database-specific SQL
✔ Complex queries
✔ Performance optimization

### Example

```java
@Query(
  value = "select * from product where price > ?1",
  nativeQuery = true
)
List<Product> getExpensive(Double price);
```

---

## ✔ Native Insert / Update / Delete

```java
@Transactional
@Modifying
@Query(value = "update product set price = ?2 where id = ?1", nativeQuery = true)
void updatePrice(Long id, Double price);
```

### Notes:

* `@Modifying` is mandatory for update/delete
* `@Transactional` required because these change DB state

---

# ----------------------------------

# ✅ **4. CRITERIA API (Dynamic Queries)**

# ----------------------------------

Used when queries depend on **runtime conditions** (filters, search page, dynamic fields).

### Example:

```java
@Autowired
EntityManager em;

public List<Product> dynamicSearch(Double price, String category) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Product> query = cb.createQuery(Product.class);

    Root<Product> root = query.from(Product.class);

    Predicate p = cb.conjunction();

    if (price != null)
        p = cb.and(p, cb.greaterThan(root.get("price"), price));

    if (category != null)
        p = cb.and(p, cb.equal(root.get("category"), category));

    query.where(p);

    return em.createQuery(query).getResultList();
}
```

Good for:
✔ Dynamic filters
✔ Admin panels
✔ Search API
✔ Avoiding string-based queries

---

# ----------------------------------

# ✅ **Summary Table — When to Use What?**

# ----------------------------------

| Query Type          | When to Use                | Difficulty |
| ------------------- | -------------------------- | ---------- |
| **Derived Queries** | Simple queries             | ⭐ Easy     |
| **JPQL**            | Joins + custom logic       | ⭐⭐ Medium  |
| **Native SQL**      | Very complex, DB-optimized | ⭐⭐⭐ Hard   |
| **Criteria API**    | Dynamic queries            | ⭐⭐⭐ Hard   |

---

# ----------------------------------

# ✅ **BONUS: Common JPA Query Errors**

# ----------------------------------

### ❌ `QuerySyntaxException: product is not mapped`

You used table name instead of Entity name.

### ❌ `ParameterBindingException`

Mismatch between parameter names in query & method.

### ❌ `ModifyingQueryException`

Missing `@Modifying` for update/delete.

### ❌ `TransactionRequiredException`

Update/Delete used without `@Transactional`.

---

# ----------------------------------

# 🎯 **If you want, I can generate a PDF with all diagrams + examples.**

Just say **“generate PDF for JPA queries”**.

Would you like **diagrams** for:

* JPQL flow
* Criteria API flow
* Derived query method resolution

Just tell me **YES**.
