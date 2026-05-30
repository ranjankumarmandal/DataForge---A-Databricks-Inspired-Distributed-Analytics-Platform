class QueryAssistantService:

    def generate_sql(
        self,
        question: str
    ) -> str:

        question_lower = question.lower()

        if "customers" in question_lower:
            return "SELECT * FROM customers LIMIT 100"

        if "orders" in question_lower:
            return "SELECT * FROM orders LIMIT 100"

        if "revenue" in question_lower:
            return """
SELECT customer_id,
       SUM(amount) AS revenue
FROM orders
GROUP BY customer_id
ORDER BY revenue DESC
LIMIT 10
"""

        return "-- Unable to generate SQL"