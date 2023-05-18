CREATE TABLE IF NOT EXISTS sells (
    id SERIAL PRIMARY KEY,
    sell_date TIMESTAMP NOT NULL,
    car_id INT NOT NULL REFERENCES cars(id),
    amount INT NOT NULL,
    full_price INT NOT NULL,
    person_id INT NOT NULL REFERENCES persons(id)
);

COMMENT ON TABLE sells IS 'Продажи';
COMMENT ON COLUMN sells.id IS 'Идентификатор продажи';
COMMENT ON COLUMN sells.sell_date IS 'Дата продажи';
COMMENT ON COLUMN sells.car_id IS 'Идентификатор проданного авто';
COMMENT ON COLUMN sells.amount IS 'Количество';
COMMENT ON COLUMN sells.full_price IS 'Общая стоимость авто';
COMMENT ON COLUMN sells.person_id IS 'Идентификатор клиента';