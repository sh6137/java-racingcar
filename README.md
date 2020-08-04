	/***
	 * 
	 *  사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
		입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
		나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
		문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
		예를 들어 
		2 + 3 * 4 / 2
		와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
		2+3*4/2
		
		사칙연산 기호가 아닌 경우 IllegalArgumentException throw
		사칙 연산을 모두 포함하는 기능 구현
		반복적인 패턴을 찾아 반복문으로 구현한다.
	 * 
	 */
	 /****************
	 1. README.md 를 이용하는건 어떨까요 ?
		README.md 사용했습니다.
		
		2. 이번 과정에서는 들여쓰기를 1회로 제한하고 있습니다.
		swith 문의 사용도 지양하고 있구요, 어떻게 리펙토링 할 수 있을까요 ?
		if문으로 대체했습니다. 함수로 분리해서 사용하였으나 이 부분이 맞게 사용한건지는 잘 모르겠습니다..
		
		3. static 으로 선언하신 이유가 있을까요?
		해당 객체를 여러곳에서 사용하게 된다면 어떻게 될까요 ?
		파라미터를 작게 가져오기 위해서 static을 사용해 보았으나, static 사용시 여러곳에서 사용하면 값이 변하여 원하는 결과값이 안 나올수 있다는 사실을 잊었습니다.
		해당 파라미터 수정하였습니다.
						
		4. 별도의 메소드로 분리하여 얻을 수 있는 이점이 무엇이 있을까요 ?
		2단계 기능분리 힌트에 테스트할 수 있는 단위로 나누어 구현목록을 만들라고 써있기도 했고,
		메소드를 가능한 작게 나누어보라고 하셔서 일단은 나누었습니다.
		합쳐서 다시 만들어보았는데, 해당 부분에 대한 답이 아니었다면, 재작성하겠습니다.
		
		5. 0으로 나누면 어떻게 될까요 ?
		0으로 나누게 되면 난수로 값이 나오게 됩니다. 해당 부분을 test쪽에 넣었는데 맞게 넣었는지 잘 모르겠습니다.
		
		6. BSD 스타일로 코드를 작성하는 큰 이유가 있으신가요?
		Java의 기본 포멧팅은 K&R 을 따르고 있습니다.
		대괄호가 위아래로 딱 맞게 되어있을 때 이쁜것 같아서 그렇게 계속 사용했습니다.
		K&R을 따르도록 하겠습니다.
		
		7. 전체적으로 코드스타일을 맞춰주는건 어떤까요 ?
		인텔리제이가 아니라 스타일이 자동정렬되지 않으나, 앞으로 코드스타일을 맞추기 위해 노력하겠습니다.
		
		8. 무의미한 공백은 제거해주세요.
		제거했습니다.
		
		9. 프러덕션 코드를 테스트 할 수 있도록 해주세요.
		프러덕션 코드의 개념이 아직 잘 잡히지 않았습니다. Exception관련된 코드가 프로덕션 코드라고 하면 기본적으로 해당 부분으로 수정해보았습니다.
		
		10. exception 을 try catch 로 받아서 처리하셨네요, 그럼 원하는 결과를 얻을 실 수 없을 것 같습니다.
		에러가 난 경우 catch 구문에서 처리히지않고 테스트 진행해주세요.
		확인했습니다. 감사합니다
	 *********************/