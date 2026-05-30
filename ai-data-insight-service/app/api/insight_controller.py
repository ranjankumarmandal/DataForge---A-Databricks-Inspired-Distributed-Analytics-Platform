from fastapi import APIRouter

from app.schemas.insight_request import (
    InsightRequest
)

from app.schemas.insight_response import (
    InsightResponse
)

from app.services.insight_service import (
    InsightService
)

router = APIRouter()

service = InsightService()


@router.post(
    "/insights",
    response_model=InsightResponse
)
async def generate_insights(
    request: InsightRequest
):

    summary = service.generate_summary(
        dataset_name=request.datasetName,
        rows=request.rows,
        columns=request.columns,
        null_percentage=request.nullPercentage
    )

    return InsightResponse(
        summary=summary
    )