package aa;

import java.net.*;
import java.io.*;

// 영원2
public class iltassafy {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "이영원";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println(order);
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				





				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];
				
				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				float targetBall_x = balls[1][0];
				float targetBall_y = balls[1][1];
				
				double minDist = Double.MAX_VALUE;
				double distance = Double.MAX_VALUE;
				
				float w = 0;
				float h = 0;
				float width = w;
				float height = h;
				
				// 가장 가까운 공으로 minDist, distance 업데이트
				if(order==1) {
					int[] arr1 = {1,3,5};
					for (int i = 0; i < arr1.length; i++) {
						w = Math.abs(whiteBall_x - balls[arr1[i]][0]);
						h = Math.abs(whiteBall_y - balls[arr1[i]][1]);
//						System.out.println(w + " " + h + " " + distance);
						if(balls[arr1[i]][0]!=-1 && Math.sqrt((w * w) + (h * h)) < minDist) {
							if(targetBall_x != -1 && arr1[i]==5) break;
							targetBall_x = balls[arr1[i]][0];
							targetBall_y = balls[arr1[i]][1];
							width = w;
							height = h;
							distance = Math.sqrt((w * w) + (h * h));
							minDist = distance;
//							System.out.println(targetBall_x + " " + targetBall_y + " " + width + " " + height + " " + minDist);
						}
					}
				}else {
					int[] arr2 = {2,4,5};
					for (int i = 0; i < arr2.length; i++) {
						w = Math.abs(whiteBall_x - balls[arr2[i]][0]);
						h = Math.abs(whiteBall_y - balls[arr2[i]][1]);
//						System.out.println(w + " " + h + " " + distance);
						if(balls[arr2[i]][0]!=-1 && Math.sqrt((w * w) + (h * h)) < minDist) {
							if(targetBall_x != -1 && arr2[i]==5) break;
							targetBall_x = balls[arr2[i]][0];
							targetBall_y = balls[arr2[i]][1];
							width = w;
							height = h;
							distance = Math.sqrt((w * w) + (h * h));
							minDist = distance;
//							System.out.println(targetBall_x + " " + targetBall_y + " " + width + " " + height + " " + minDist);
						}
					}
				}

				
				System.out.println(width + " " + height + " " + distance);
				
				float targetHole_x = 0.0f;
				float targetHole_y = 0.0f;
				float holeWidth = w;
				float holeHeight = h;
				double holeDist = 250;
				float ang = 180.0f;
				
				// 가장 가까운 홀 찾기
				for (int i = 0; i < HOLES.length; i++) {
					w = Math.abs(targetBall_x - HOLES[i][0]);
					h = Math.abs(targetBall_y - HOLES[i][1]);
					holeDist = Math.sqrt((w * w) + (h * h));
//					ang = (float) (180.0-Math.toDegrees(Math.acos((Math.pow(holeDist, 2)+Math.pow(distance, 2)-(Math.pow(Math.abs(balls[0][0]-HOLES[i][0]), 2) + Math.pow(Math.abs(balls[0][1]-HOLES[i][1]), 2)))/(2*holeDist*distance))));
					if((float) Math.abs((180.0-Math.toDegrees(Math.acos((Math.pow(holeDist, 2)+Math.pow(distance, 2)-(Math.pow(Math.abs(balls[0][0]-HOLES[i][0]), 2) + Math.pow(Math.abs(balls[0][1]-HOLES[i][1]), 2)))/(2*holeDist*distance))))) < ang) {
						ang = (float) Math.abs((180.0-Math.toDegrees(Math.acos((Math.pow(holeDist, 2)+Math.pow(distance, 2)-(Math.pow(Math.abs(balls[0][0]-HOLES[i][0]), 2) + Math.pow(Math.abs(balls[0][1]-HOLES[i][1]), 2)))/(2*holeDist*distance)))));
						switch(i) {
						case 0:
							targetHole_x = HOLES[i][0]+1;
							targetHole_y = HOLES[i][1]+1;
							break;
						case 1:
							targetHole_x = HOLES[i][0];
							targetHole_y = HOLES[i][1]+1;
							break;
						case 2:
							targetHole_x = HOLES[i][0]-1;
							targetHole_y = HOLES[i][1]+1;
							break;
						case 3:
							targetHole_x = HOLES[i][0]+1;
							targetHole_y = HOLES[i][1]-1;
							break;
						case 4:
							targetHole_x = HOLES[i][0];
							targetHole_y = HOLES[i][1]-1;
							break;
						case 5:
							targetHole_x = HOLES[i][0]-1;
							targetHole_y = HOLES[i][1]-1;
							break;
						}
//						targetHole_x = HOLES[i][0]-1;
//						targetHole_y = HOLES[i][1]-1;
						holeWidth = w;
						holeHeight = h;
						holeDist = Math.sqrt((w * w) + (h * h));
						System.out.println(i + "번 홀 선택");
					}
//
//					System.out.println(ang);
//					if(Math.sqrt((w * w) + (h * h)) < holeDist) {
//						targetHole_x = HOLES[i][0];
//						targetHole_y = HOLES[i][1];
//						holeWidth = w;
//						holeHeight = h;
//						holeDist = Math.sqrt((w * w) + (h * h));
//					}
				}
				
				float update_w = (float) (5.00f / holeDist * holeWidth);
				float update_h = (float) (5.00f / holeDist * holeHeight);
				
				System.out.println(targetHole_x + " " + targetHole_y + " " + holeWidth + " " + holeHeight + " " + holeDist + " " + update_w + " " + update_h);
				System.out.println(targetBall_x + " " + targetBall_y);
				
				// 홀이 목적구를 중심으로 3사분면에 위치했을 때 각도를 재계산
				if (targetBall_x > targetHole_x && targetBall_y > targetHole_y)
				{
					targetBall_x = targetBall_x + update_w;
					targetBall_y = targetBall_y + update_h;	
				}

				// 홀이 목적구를 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (targetBall_x < targetHole_x && targetBall_y > targetHole_y)
				{
					targetBall_x = targetBall_x - update_w;
					targetBall_y = targetBall_y + update_h;	
				}
				
				// 홀이 목적구를 중심으로 1사분면에 위치했을 때 각도를 재계산
				else if (targetBall_x < targetHole_x && targetBall_y < targetHole_y)
				{
					targetBall_x = targetBall_x - update_w;
					targetBall_y = targetBall_y - update_h;	
				}
				
				// 홀이 목적구를 중심으로 2사분면에 위치했을 때 각도를 재계산
				else if (targetBall_x > targetHole_x && targetBall_y < targetHole_y)
				{
					targetBall_x = targetBall_x + update_w;
					targetBall_y = targetBall_y - update_h;	
				}
				
				width = Math.abs(targetBall_x - whiteBall_x);
				height = Math.abs(targetBall_y - whiteBall_y);
				
				System.out.println(targetBall_x + " " + targetBall_y);

				
				
				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리

//				float width = Math.abs(targetBall_x - whiteBall_x);
//				float height = Math.abs(targetBall_y - whiteBall_y);
				
				// distance: 두 점(좌표) 사이의 거리를 계산
				distance = Math.sqrt((width * width) + (height * height));



				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				//   - 1radian = 180 / PI (도)
				//   - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0? Math.atan(width / height): 0;
				angle = (float) ((180.0 / Math.PI) * radian);

				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_x)
				{
					if (whiteBall_y < targetBall_y)
					{
						angle = 0;
					}
					else
					{
						angle = 180;
					}
				}
				else if (whiteBall_y ==targetBall_y)
				{
					if (whiteBall_x < targetBall_x)
					{
						angle = 90;
					}
					else
					{
						angle = 270;
					}
				}

				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y)
				{
					radian = Math.atan(width / height);
					System.out.println(3 + " " + radian + " " + Math.toDegrees(radian));
					angle = (float) (((180.0 / Math.PI) * radian) + 180);
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y)
				{
					radian = Math.atan(height / width);
					System.out.println(4 + " " + radian + " " + Math.toDegrees(radian));
					angle = (float) (((180.0 / Math.PI) * radian) + 90);
				}
				
				// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_x && whiteBall_y < targetBall_y)
				{
					radian = Math.atan(width / height);
					System.out.println(1 + " " + radian + " " + Math.toDegrees(radian));
					angle = (float) (Math.toDegrees(radian));
				}
				
				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y)
				{
					radian = Math.atan(height / width);
					System.out.println(2 + " " + radian + " " + Math.toDegrees(radian));
					angle = (float) (((180.0 / Math.PI) * radian) + 270);
				}
				


				// power: 거리 distance에 따른 힘의 세기를 계산
				power = (distance >= 80) ? (float) 80 : 40;
				

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
