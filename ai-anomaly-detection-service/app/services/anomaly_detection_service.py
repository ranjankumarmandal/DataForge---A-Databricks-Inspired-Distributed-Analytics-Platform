import numpy as np

from sklearn.ensemble import IsolationForest


class AnomalyDetectionService:

    def detect(
        self,
        values: list[float]
    ) -> list[float]:

        data = np.array(values).reshape(-1, 1)

        model = IsolationForest(
            contamination="auto",
            random_state=42
        )

        predictions = model.fit_predict(data)

        anomalies = []

        for value, prediction in zip(values, predictions):

            if prediction == -1:
                anomalies.append(value)

        return anomalies