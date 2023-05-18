CREATE TABLE IF NOT EXISTS persons (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    phone VARCHAR NOT NULL
);

COMMENT ON TABLE persons IS 'Клиенты';
COMMENT ON COLUMN persons.id IS 'Идентификатор клиента';
COMMENT ON COLUMN persons.first_name IS 'Имя клиента';
COMMENT ON COLUMN persons.last_name IS 'Фамилия клиента';
COMMENT ON COLUMN persons.phone IS 'Телефон клиента';