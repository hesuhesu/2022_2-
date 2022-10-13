import square2, person

def main() :
    eun = person.Person("eun", 24, "Busan-Namgu")
    eun.greeting()
    square2.base, n = map(int, input("n의 m승이다. n^m을 기입하라 : ").split("^"))
    print(square2.square(n))

if __name__ == "__main__" :
    main()