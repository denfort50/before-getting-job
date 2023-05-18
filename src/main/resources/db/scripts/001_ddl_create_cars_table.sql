CREATE TABLE IF NOT EXISTS cars (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

COMMENT ON TABLE cars IS 'Автомобили';
COMMENT ON COLUMN cars.id IS 'Идентификатор автомобиля';
COMMENT ON COLUMN cars.name IS 'Модель автомобиля';