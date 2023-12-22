import numpy as np

# 주어진 점들
points = {'A': (0, 3), 'B': (7, 5), 'C': (6, 0), 'D': (4, 3),
          'E': (1, 0), 'F': (5, 3), 'H': (4, 1), 'G': (2, 2)}

# 유전 알고리즘 파라미터
population_size = 8
crossover_ratio = 1.0
mutation_ratio = 0.01
iterations = 5000

# 두 점 간 거리를 계산하는 헬퍼 함수
def calculate_distance(point1, point2):
    return np.sqrt((point1[0] - point2[0]) ** 2 + (point1[1] - point2[1]) ** 2)

# 초기 개체 집단 생성
population = [list(points.keys()) for _ in range(population_size)]

# 메인 루프
for iteration in range(iterations):
    # 적응도 계산
    fitness = []
    for i in range(population_size):
        total_distance = 0
        for j in range(len(points)):
            total_distance += calculate_distance(
                points[population[i][j]],
                points[population[i][(j + 1) % len(points)]]
            )
        fitness.append(total_distance)

    # 번식을 위한 후보 선택
    selected_indices = np.argsort(fitness)[:int(crossover_ratio * population_size)]

    # 교차 (Cycle Crossover)
    offspring = []
    for i in range(0, len(selected_indices), 2):
        parent1 = population[selected_indices[i]]
        parent2 = population[selected_indices[i + 1]]
        child1, child2 = [None] * len(parent1), [None] * len(parent2)

        # 사이클로 초기화
        cycle_start = np.random.randint(len(parent1))
        j = cycle_start  # j의 값을 초기화합니다.
        while child1[cycle_start] is None:
            child1[j] = parent1[j]
            child2[j] = parent2[j]
            j = parent1.index(parent2[j])

        # 나머지 요소 채우기
        for j in range(len(parent1)):
            if child1[j] is None:
                child1[j] = parent2[j]
                child2[j] = parent1[j]

        offspring.extend([child1, child2])

    # 돌연변이
    for i in range(population_size):
        if np.random.rand() < mutation_ratio:
            mutation_point1, mutation_point2 = np.random.choice(len(points), 2, replace=False)
            population[i][mutation_point1], population[i][mutation_point2] = population[i][mutation_point2], population[i][mutation_point1]

# 루프 이후에 최적해 선택
best_solution_index = np.argmin(fitness)
best_solution_order = population[best_solution_index]
best_solution_distance = fitness[best_solution_index]

print("최적해 이동 순서:", best_solution_order)
print("최적해 이동 거리:", best_solution_distance)