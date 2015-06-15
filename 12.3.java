test boolean canMoveTo(int x, int y)

1 Extreme Case Validateion
negative numbers for x and y
x larger than width, y larger than height
complete full board
empty or nearly empty board
far more white pieces than black
far more black pieces than white


2 General Testing
foreach piece a:
	for each other type of piece b(6 types + empty space)
		foreach direction default:
			create a board with piece a
			place piece b in direction d
			try to move - check return value

