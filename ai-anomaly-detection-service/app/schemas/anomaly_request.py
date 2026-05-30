from pydantic import BaseModel


class AnomalyRequest(BaseModel):
    values: list[float]