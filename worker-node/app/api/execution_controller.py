from fastapi import APIRouter

from app.schemas.execution_request import (
    ExecutionRequest
)

from app.schemas.execution_response import (
    ExecutionResponse
)

from app.services.execution_service import (
    ExecutionService
)

router = APIRouter()

service = ExecutionService()


@router.post(
    "/execute",
    response_model=ExecutionResponse
)
async def execute(
    request: ExecutionRequest
):

    result = service.execute(
        request.code
    )

    return ExecutionResponse(
        status="SUCCESS",
        output=result
    )