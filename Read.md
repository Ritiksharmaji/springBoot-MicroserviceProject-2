1) ![img.png](img.png)

# ---------- what is @ControllerAdvice use of it ---
`@ControllerAdvice` (or `@RestControllerAdvice`) is one of the **most important** Spring annotations for building clean, production-level APIs.

Let me explain it in a very simple and practical way.

---

# 🚀 **What is `@ControllerAdvice`?**

`@ControllerAdvice` is a **global exception handler** or **global controller interceptor**.

It allows you to:

### ✔ Handle exceptions globally

### ✔ Apply validations globally

### ✔ Modify response bodies

### ✔ Bind model attributes

### ✔ Handle @InitBinder methods

So instead of writing error-handling code in every controller,
**you write it once in `@ControllerAdvice` and Spring applies it to all controllers.**

---

# ⭐ Recommended for APIs: `@RestControllerAdvice`

Use this for REST APIs because it automatically applies `@ResponseBody`.

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

}
```

---

# 🧨 WHY do we need `@ControllerAdvice`?

Without it — every controller needs its own:

❌ try-catch
❌ repeated error response code
❌ repeated `@ExceptionHandler`
❌ messy controller code

With `@ControllerAdvice`:

✔ clean
✔ centralized
✔ reusable
✔ maintainable

---

# ✅ **Simple Example: Handle NotFoundException Globally**

### 1️⃣ Create Exception

```java
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
```

> Prefer extending **RuntimeException**, not `Exception`.

---

### 2️⃣ Create `@RestControllerAdvice`

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ExceptionDto handleNotFoundException(NotFoundException ex) {
        return new ExceptionDto(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
    }
}
```

---

### 3️⃣ Controller stays clean (no try-catch)

```java
@GetMapping("/{id}")
public GenericProductDto getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
}
```

---

### 4️⃣ Service throws exception if missing

```java
public GenericProductDto getProductById(Long id) {
    GenericProductDto product = restClient.get()
            .uri("/products/" + id)
            .retrieve()
            .body(GenericProductDto.class);

    if (product == null) {
        throw new NotFoundException("Product not found with id: " + id);
    }

    return product;
}
```

---

# 🎯 **Result**

When product not found:

### Response

```json
{
  "httpStatus": "NOT_FOUND",
  "message": "Product not found with id: 10"
}
```

### Status code:

```
404 Not Found
```

And NO try-catch needed in controller.

---

# 📌 Other things `@ControllerAdvice` can do

### ✔ Global exception handling

### ✔ Global @ModelAttribute

### ✔ Global request preprocessing

### ✔ Global validation handling

---

# 🧠 Summary Table

| Feature         | With ControllerAdvice | Without  |
| --------------- | --------------------- | -------- |
| Error handling  | Centralized           | Repeated |
| Code            | Clean                 | Messy    |
| Reusability     | High                  | Low      |
| Maintainability | Easy                  | Hard     |

---

If you want, I can create:

🔥 Full global exception handler
🔥 Custom error response structure
🔥 Logger-enabled exception handling
🔥 Validation error handler (`@Valid`)
🔥 Handling multiple exceptions cleanly

Just tell me:
**"Give full GlobalExceptionHandler"**

# ----------- what is intersecter class --------
A **Spring Interceptor** is a special class that allows you to **intercept** (catch) incoming requests **before**, **after**, or **around** they reach a controller.

Think of an Interceptor as a **filter at the Spring MVC level**.

---

# 🚀 **What is an Interceptor Class?**

A class that implements:

```java
HandlerInterceptor
```

Spring uses this class to run logic **before** and **after** controller methods.

---

# 🎯 **Where are Interceptors used?**

Interceptors are used for:

### ✔ Authentication (check JWT before controller)

### ✔ Logging every request

### ✔ Checking headers

### ✔ Tracking execution time

### ✔ Rate limiting

### ✔ Modifying request/response

### ✔ Audit logs

---

# 🔥 **Life Cycle of an Interceptor**

Spring runs interceptor methods in this order:

### 1️⃣ `preHandle()` ➝ BEFORE controller

### 2️⃣ `postHandle()` ➝ AFTER controller but BEFORE sending response

### 3️⃣ `afterCompletion()` ➝ AFTER response is sent

---

# ⭐ **Interceptor Class Example**

```java
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("Pre Handle: Before Controller");
        
        // Return false to stop request going to controller
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle: After Controller");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("After Completion: After Response");
    }
}
```

---

# ⭐ How to Register Interceptor

Create a config class:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/api/**");   // apply to specific endpoints
    }
}
```

---

# 🧠 **Interceptor vs Filter vs ControllerAdvice**

| Feature            | Interceptor   | Filter                        | ControllerAdvice           |
| ------------------ | ------------- | ----------------------------- | -------------------------- |
| Level              | Spring MVC    | Servlet                       | Spring MVC                 |
| Works for          | controllers   | everything (static files too) | exceptions, model, binding |
| Before controller? | ✔ Yes         | ✔ Yes                         | ❌                          |
| After controller?  | ✔ Yes         | ❌                             | ❌                          |
| Purpose            | logging, auth | security, CORS                | exception handling         |

---

# 💡 Real use cases

### 🛡 1. JWT Authentication Interceptor

Reject request if token invalid.

### 📄 2. Logging Interceptor

Logs request URL & response time.

### 📊 3. Metrics Interceptor

Track performance.

### 🚫 4. Rate Limiter

Prevent too many requests.

---

# 💥 Simple JWT Interceptor Example

```java
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

    String authHeader = request.getHeader("Authorization");
    
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        response.setStatus(401);
        response.getWriter().write("Unauthorized");
        return false;
    }

    // validate JWT here...

    return true;
}
```

---

# 🎯 Summary

### **Interceptor Class = A Spring MVC hook to intercept requests before and after controller.**

Used for:

✔ Logging
✔ Security
✔ JWT validation
✔ Modifying requests/responses
✔ Performance monitoring

---

If you want, I can build a **JWT Interceptor**, **Logging Interceptor**, or **Execution Time Interceptor** for your project.
