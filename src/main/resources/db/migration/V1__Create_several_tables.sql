-- tables
-- Table: LoadingBays
CREATE TABLE LoadingBays (
    bay_id int NOT NULL,
    property_id int NOT NULL,
    truck_level bool NOT NULL,
    trailer_53 bool NOT NULL,
    dock_lock bool NOT NULL,
    leveler bool NOT NULL,
    CONSTRAINT LoadingBays_pk PRIMARY KEY (bay_id)
);

-- Table: MeetingRooms
CREATE TABLE MeetingRooms (
    room_id int NOT NULL,
    property_id int NOT NULL,
    capacity int NOT NULL,
    square_footage int NOT NULL,
    av_equipment bool NOT NULL,
    exclusive bool NOT NULL,
    CONSTRAINT MeetingRooms_pk PRIMARY KEY (room_id)
);

-- Table: Offices
CREATE TABLE Offices (
    property_id int NOT NULL,
    capacity int NOT NULL,
    kitchen bool NULL,
    gym bool NULL,
    parking bool NULL,
    mailservice bool NULL,
    CONSTRAINT Offices_pk PRIMARY KEY (property_id)
);

-- Table: Properties
CREATE TABLE Properties (
    property_id int NOT NULL,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    province varchar(255) NOT NULL,
    postal varchar(255) NOT NULL,
    access_247 bool NULL,
    utilities_included bool NULL,
    availability date NULL,
    cost int NULL,
    CONSTRAINT Properties_pk PRIMARY KEY (property_id)
);

-- Table: Warehouses
CREATE TABLE Warehouses (
    property_id int NOT NULL,
    square_footage int NOT NULL,
    forklifts bool NULL,
    parking_trailer bool NULL,
    fenced_yard bool NULL,
    power_amps int NULL,
    CONSTRAINT Warehouses_pk PRIMARY KEY (property_id)
);
