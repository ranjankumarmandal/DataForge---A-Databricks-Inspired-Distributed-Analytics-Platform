from fastapi import FastAPI

app = FastAPI(
    title="AI Query Assistant Service",
    version="1.0.0"
)


@app.get("/health")
async def health():

    return {
        "service": "ai-query-assistant-service",
        "status": "UP"
    }


@app.get("/")
async def root():

    return {
        "message": "AI Query Assistant Service Running"
    }