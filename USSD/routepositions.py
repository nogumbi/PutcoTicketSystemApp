import random
import math

routestart = []
routesend = []

def get_routes():
    global routestart
    global routesend

    route_count1 = random.randint(1,1)
    for i in range(0, route_count1):
        (x, y) = random.randint(-100, 100), random.randint(-100, 100)
        routestart.append((x, y))
        routesend.append((x, y))
    route_count2 = random.randint(1,1)
    for i in range(0, route_count2):
        (x, y) = random.randint(-100, 100), random.randint(-100, 100)
        routesend.append((x, y))  
    return routestart, routesend


def print_routes():
    global routestart
    global routesend

    get_routes()
    for route1 in routestart:
        x1 = route1[0]
        y1 = route1[1]
    for route2 in routesend:
        x2 = route2[0]
        y2 = route2[1]
    

    distance_ = math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    
    return distance_
