CREATE TABLE datasets (
    id UUID PRIMARY KEY,
    tenant_id VARCHAR(100) NOT NULL,
    dataset_name VARCHAR(255) NOT NULL,
    dataset_type VARCHAR(50) NOT NULL,
    storage_path TEXT,
    schema_definition JSONB,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_datasets_tenant
ON datasets(tenant_id);

CREATE INDEX idx_datasets_name
ON datasets(dataset_name);