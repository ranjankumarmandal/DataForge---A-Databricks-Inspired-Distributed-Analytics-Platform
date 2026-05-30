from fastapi import APIRouter

from app.schemas.anomaly_request import (
    AnomalyRequest
)

from app.schemas.anomaly_response import (
    AnomalyResponse
)

from app.services.anomaly_detection_service import (
    AnomalyDetectionService
)

router = APIRouter()

service = AnomalyDetectionService()


@router.post(
    "/detect",
    response_model=AnomalyResponse
)
async def detect_anomalies(
    request: AnomalyRequest
):

    anomalies = service.detect(
        request.values
    )

    return AnomalyResponse(
        anomalies=anomalies
    )