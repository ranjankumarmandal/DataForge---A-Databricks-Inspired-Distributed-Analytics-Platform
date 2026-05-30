from fastapi import FastAPI

from app.api.query_controller import router


app = FastAPI(
    title="AI Query Assistant Service",
    version="1.0.0"
)

app.include_router(
    router,
    prefix="/api/v1"
)


@app.get("/health")
async def health():

    return {
        "service": "ai-query-assistant-service",
        "status": "UP"
    }