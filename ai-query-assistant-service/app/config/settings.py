from pydantic_settings import BaseSettings


class Settings(BaseSettings):

    SERVICE_PORT: int = 8092

    REDIS_HOST: str
    REDIS_PORT: int

    KAFKA_BOOTSTRAP_SERVERS: str

    QUERY_ENGINE_URL: str

    METADATA_SERVICE_URL: str

    HF_MODEL: str

    class Config:
        env_file = ".env"


settings = Settings()