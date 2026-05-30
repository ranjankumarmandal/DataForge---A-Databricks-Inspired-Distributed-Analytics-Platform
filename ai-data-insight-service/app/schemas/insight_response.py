from pydantic import BaseModel


class InsightResponse(BaseModel):

    summary: str