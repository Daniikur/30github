# Advanced SQL Queries & Indexing

This repository contains exercises and tasks focused on mastering advanced SQL queries and indexing techniques for database optimization. The goal is to enhance the performance of your SQL queries and ensure that your database remains efficient as it scales with more data.

## 🔑 Overview

- **SQL Optimization**: Learn how to write advanced SQL queries for data retrieval and optimization.
- **Indexing**: Understand the importance of indexing in improving query performance.
- **Database Maintenance**: Learn about tools like **VACUUM ANALYZE** to keep your database in optimal shape.

---

## 📄 Tasks Completed

### 1. Advanced SQL Queries

- **JOINs**: Mastered different types of joins:
  - **INNER JOIN**
  - **LEFT JOIN**
  - **RIGHT JOIN**
  - **FULL OUTER JOIN**

- **Subqueries**: Worked with both correlated and non-correlated subqueries to filter results based on other queries.

- **Aggregations**: Used `GROUP BY` and `HAVING` clauses to group data and filter aggregate results.
  - Example: `SELECT department, AVG(salary) AS avg_salary FROM employees GROUP BY department HAVING AVG(salary) > 60000;`

- **Window Functions**: Applied window functions like `ROW_NUMBER()` and `RANK()` to perform calculations across a set of rows related to the current row.
  - Example: `SELECT name, salary, ROW_NUMBER() OVER (ORDER BY salary DESC) AS rank FROM employees;`

- **Common Table Expressions (CTEs)**: Used CTEs for breaking down complex queries into readable, reusable parts.
  - Example: 
    ```sql
    WITH DepartmentAvg AS (
        SELECT department, AVG(salary) AS avg_salary
        FROM employees
        GROUP BY department
    )
    SELECT * FROM DepartmentAvg WHERE avg_salary > 60000;
    ```

- **Recursive Queries**: Created recursive queries to build hierarchical data like employee-manager relationships.

### Screenshot of Query Results:

![Query Results Screenshot](![Screenshot 2025-02-18 130953](https://github.com/user-attachments/assets/e7a0916d-7eb9-4763-a643-b9353f67d704)
)
![Query Results Screenshot](![Screenshot 2025-02-18 131309](https://github.com/user-attachments/assets/c9d831d4-4170-41b5-83dd-90249cad3658)
)
![Query Results Screenshot](![Screenshot 2025-02-18 131535](https://github.com/user-attachments/assets/55f2f4dd-ea02-4fd6-9f64-f1c7c36070ed)
)

---

### 2. Indexing Techniques

- **Creating Indexes**: Created and optimized different types of indexes.
  - **B-tree Index**: Default index type for most database systems.
    ```sql
    CREATE INDEX idx_name ON employees(name);
    ```
  - **Hash Index**: Used for equality comparisons.
    ```sql
    CREATE INDEX idx_hash_name ON employees USING HASH(name);
    ```
  - **Composite Index**: Created indexes involving multiple columns for optimized querying.
    ```sql
    CREATE INDEX idx_name_salary ON employees(name, salary);
    ```

- **Indexing Best Practices**: Learned to:
  - Use indexes on columns involved in `WHERE`, `JOIN`, and `ORDER BY` clauses.
  - Avoid over-indexing to prevent negative impacts on `INSERT`, `UPDATE`, and `DELETE` performance.

- **Covering Indexes**: Used covering indexes to include all the columns required for a query in the index itself, making the query more efficient.
  - Example: `CREATE INDEX idx_name_salary ON employees(name, salary);`

- **EXPLAIN ANALYZE**: Used `EXPLAIN ANALYZE` to check if queries are using indexes effectively and measure query performance.
  - Example:
    ```sql
    EXPLAIN ANALYZE SELECT * FROM employees WHERE name = 'Alice';
    ```

---

### 3. Database Maintenance

- **VACUUM ANALYZE**: Used the `VACUUM ANALYZE` command to clean up dead tuples and update statistics to keep the database optimized.
  - Command:
    ```sql
    VACUUM ANALYZE employees;
    ```

- **Result**: After running `VACUUM ANALYZE`, the database is free from dead tuples and indexes are more efficient.

---

## ✅ Results

- **Database Optimization**: Your database is now well-optimized for both read and write operations.
- **Efficient Indexing**: Indexes are functioning efficiently, speeding up your queries.
- **No Dead Tuples**: Thanks to `VACUUM ANALYZE`, dead tuples have been cleared, and database statistics are updated.
- **Scalability**: With these techniques in place, your database is ready to handle larger datasets and scale without performance issues.

---

## 🔧 Future Tasks

- **Test Performance with Larger Data**: Populate the database with more data and observe the performance of queries and indexing.
- **Advanced Indexing Techniques**: Explore further index optimization techniques like **Partial Indexes** and **Full-Text Indexes**.
- **Query Optimization**: Continue optimizing queries by using execution plans and refining the database schema.

---

## 📚 References

- [PostgreSQL Documentation on Indexing](https://www.postgresql.org/docs/current/indexes.html)
- [SQL Window Functions](https://www.sqlservertutorial.net/sql-server-window-functions/)
- [Common Table Expressions in SQL](https://www.sqlshack.com/common-table-expression-cte-in-sql-server/)

---

