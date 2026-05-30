from pydantic import BaseModel


class QueryResponse(BaseModel):
    question: str
    generated_sql: str