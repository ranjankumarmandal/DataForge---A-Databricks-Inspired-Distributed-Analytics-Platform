from pydantic import BaseModel


class InsightRequest(BaseModel):

    datasetName: str

    rows: int

    columns: int

    nullPercentage: float