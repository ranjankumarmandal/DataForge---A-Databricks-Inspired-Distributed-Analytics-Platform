from fastapi import FastAPI

from app.api.execution_controller import router

app = FastAPI(
    title="Worker Node",
    version="1.0.0"
)

app.include_router(
    router,
    prefix="/api/v1"
)


@app.get("/health")
async def health():

    return {
        "service": "worker-node",
        "status": "UP"
    }