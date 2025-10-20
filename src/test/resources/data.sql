CREATE TABLE IF NOT EXISTS productos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    precio DECIMAL,
    descripcion VARCHAR(255)
);
INSERT INTO productos (nombre, precio, descripcion)
VALUES ('Chocolate', 1000.00, 'Chocolate');
INSERT INTO public.productos(nombre, precio, descripcion)
VALUES ('Pastel',1000.00,'Pastel');