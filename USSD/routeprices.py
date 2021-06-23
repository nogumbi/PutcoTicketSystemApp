import routepositions

position_x = 0
position_y = 0

# min_y, max_y = -200, 200
# min_x, max_x = -100, 100

def print_routes(routes):
    print("Route positions")
    for route in routes:
        print({route[0], route[1]})

print_routes(routes)