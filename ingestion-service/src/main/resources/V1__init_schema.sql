CREATE TABLE ingestion_jobs (

    id UUID PRIMARY KEY,

    tenant_id VARCHAR(100) NOT NULL,

    dataset_name VARCHAR(255) NOT NULL,

    file_name VARCHAR(500) NOT NULL,

    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_ingestion_jobs_tenant
ON ingestion_jobs(tenant_id);