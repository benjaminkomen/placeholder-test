-- Property 1
INSERT INTO Properties VALUES (1, 'Ikea', '102 Main Street', 'Vancouver', 'British Columbia', '101 ABA', null, true, '2022-05-05', null);
INSERT INTO Warehouses VALUES (1, 3500, false, false, true, null);
INSERT INTO LoadingBays VALUES (11, 1, true, true, true, true);
INSERT INTO LoadingBays VALUES (12, 1, false, false, false, false);

-- Property 2
INSERT INTO Properties VALUES (2, 'Walmart', '991 Fraser Street', 'Victoria', 'British Columbia', '991 ZZZ', null, false, '2022-09-01', null);
INSERT INTO Offices VALUES (2, 999, true, false, true, null);
INSERT INTO MeetingRooms VALUES (21, 2, 5, 88, false, true);
INSERT INTO MeetingRooms VALUES (22, 2, 30, 999, true, false);
