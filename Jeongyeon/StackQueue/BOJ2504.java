//���� S1 ��ȣ�� ��
import java.io.;
import java.util.Stack;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		char[] bracket = bf.readLine().toCharArray();
		StackCharacter stack = new StackCharacter();
		int answer = 0, current = 1;
		
		for (int i=0; ibracket.length; i++) {
		    if (bracket[i] == '(') {  ���� ��ȣ�� ������ stack.push()
		        stack.push(bracket[i]);
		        current = 2;  ��ȣ�� ������ ��ȣ�� ���ϱ�
		    }
		    
		    else if (bracket[i] == '[') {
		        stack.push(bracket[i]);
		        current = 3;
		    }
		    
		    else if (bracket[i] == ')') {  �ݴ� ��ȣ�� ���, �������� �Է����� üũ
		        if (stack.empty()  stack.peek() != '(') {
		             empty stack�̰ų� ��ȣ�� �ϼ��� �� ���� ��� ������ �Է�
		            answer = 0;
		            break;
		        }
		        
		        else if (bracket[i-1] == '(') {  ���� ��ȣ���� �ּ� ������ () or []�̸�
		            answer += current;  ���ο� ������ ����� �����Ƿ� �ܼ� ����
		        }
		        
		        stack.pop();
		        current = 2;  ��ȣ�� ������ ��ȣ�� �ѹ� ������
		    }
		    
		    else {
		        if (stack.empty()  stack.peek() != '[') {
		            answer = 0;
		            break;
		        }
		        
		        else if (bracket[i-1] == '[') {
		            answer += current;
		        }
		        
		        stack.pop();
		        current = 3;
		    }
		}
		
		if (!stack.isEmpty()) {
		    answer = 0;
		}
		System.out.println(answer);
	}
}
