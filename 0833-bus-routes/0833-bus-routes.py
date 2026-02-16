class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        if source == target:
            return 0

        stop_to_routes = defaultdict(list)
        for i, route in enumerate(routes):
            for stop in route:
                stop_to_routes[stop].append(i)

        q = deque([source])
        visited_stops = set([source])
        visited_routes = set()
        buses = 0

        while q:
            buses += 1
            for _ in range(len(q)):
                stop = q.popleft()

                for r in stop_to_routes[stop]:
                    if r in visited_routes:
                        continue
                    visited_routes.add(r)

                    for nxt_stop in routes[r]:
                        if nxt_stop == target:
                            return buses
                        if nxt_stop not in visited_stops:
                            visited_stops.add(nxt_stop)
                            q.append(nxt_stop)

        return -1
