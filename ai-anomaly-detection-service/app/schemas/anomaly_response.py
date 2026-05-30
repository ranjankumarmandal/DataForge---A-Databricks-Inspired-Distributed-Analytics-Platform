from pydantic import BaseModel


class AnomalyResponse(BaseModel):
    anomalies: list[float]