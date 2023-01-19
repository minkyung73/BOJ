# silver V

from sys import stdin

plate = stdin.readline().strip()

height = 10
pre = plate[0]

plate = plate[1:]
for i in plate:
    if pre == i:
        height += 5
    else:
        pre = i
        height += 10

print(height)

