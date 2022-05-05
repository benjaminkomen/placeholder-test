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

-- foreign keys
-- Reference: LoadingBays_Warehouses (table: LoadingBays)
ALTER TABLE LoadingBays ADD CONSTRAINT LoadingBays_Warehouses FOREIGN KEY LoadingBays_Warehouses (property_id)
    REFERENCES Warehouses (property_id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;

-- Reference: MeetingRooms_Offices (table: MeetingRooms)
ALTER TABLE MeetingRooms ADD CONSTRAINT MeetingRooms_Offices FOREIGN KEY MeetingRooms_Offices (property_id)
    REFERENCES Offices (property_id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;

-- Reference: Offices_Properties (table: Offices)
ALTER TABLE Offices ADD CONSTRAINT Offices_Properties FOREIGN KEY Offices_Properties (property_id)
    REFERENCES Properties (property_id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;

-- Reference: Warehouses_Properties (table: Warehouses)
ALTER TABLE Warehouses ADD CONSTRAINT Warehouses_Properties FOREIGN KEY Warehouses_Properties (property_id)
    REFERENCES Properties (property_id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;

