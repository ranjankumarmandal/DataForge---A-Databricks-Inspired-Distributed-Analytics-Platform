from pydantic import BaseModel


class ExecutionRequest(BaseModel):
    code: str