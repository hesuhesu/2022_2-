from Module1 import * # *로 전부 가져온 모듈의 변수, 함수, 클래스는 언더바(_)가 적힌 것은 불러오지 않는다.

func1()
func2()
func3()

publicFunc()
Module1._privateFunc() # 정의되지 않았다고 판단. 앞에 모듈의 이름과 .을 붙여서 불러온다.