from fastapi import APIRouter

from app.schemas.query_request import QueryRequest
from app.schemas.query_response import QueryResponse

from app.services.query_assistant_service import (
    QueryAssistantService
)

router = APIRouter()

query_service = QueryAssistantService()


@router.post(
    "/query",
    response_model=QueryResponse
)
async def generate_query(
    request: QueryRequest
):

    sql = query_service.generate_sql(
        request.question
    )

    return QueryResponse(
        question=request.question,
        generated_sql=sql
    )