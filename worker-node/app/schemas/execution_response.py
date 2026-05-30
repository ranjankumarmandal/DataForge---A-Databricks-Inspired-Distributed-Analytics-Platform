from pydantic import BaseModel


class ExecutionResponse(BaseModel):
    status: str
    output: str