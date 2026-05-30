from fastapi import FastAPI

from app.api.anomaly_controller import router

app = FastAPI(
    title="AI Anomaly Detection Service",
    version="1.0.0"
)

app.include_router(
    router,
    prefix="/api/v1"
)


@app.get("/health")
async def health():

    return {
        "service": "ai-anomaly-detection-service",
        "status": "UP"
    }