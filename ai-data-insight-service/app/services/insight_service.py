class InsightService:

    def generate_summary(
        self,
        dataset_name: str,
        rows: int,
        columns: int,
        null_percentage: float
    ) -> str:

        summary = (
            f"Dataset {dataset_name} contains "
            f"{rows} rows and {columns} columns."
        )

        if null_percentage > 10:
            summary += (
                f" Data quality attention is recommended "
                f"because null percentage is "
                f"{null_percentage}%."
            )

        else:
            summary += (
                " Data quality looks healthy."
            )

        return summary