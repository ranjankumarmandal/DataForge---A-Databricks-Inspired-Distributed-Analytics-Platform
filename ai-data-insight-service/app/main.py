from fastapi import FastAPI

from app.api.insight_controller import router

app = FastAPI(
    title="AI Data Insight Service",
    version="1.0.0"
)

app.include_router(
    router,
    prefix="/api/v1"
)


@app.get("/health")
async def health():

    return {
        "service": "ai-data-insight-service",
        "status": "UP"
    }