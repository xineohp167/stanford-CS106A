
import acm.graphics.*;
import acm.program.*;
import java.awt.event.MouseEvent;;

/* This class draws a face at the center of the canvas. 
 * The eyes of the face will track the mouse's pointer as it moves around on the canvas. 
 */
public class TrackEyesToMouse extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	private static final double FACE_WIDTH = 200;
	private static final double FACE_HEIGHT = 400;
	private static final double PUPIL_RADIUS = 5;
	private static final double PUPIL_DISTANCE = 10;
	
	public void init() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		GFace face = new GFace(FACE_WIDTH, FACE_HEIGHT);
		println(face.getHeight());
		println(cy);
		add(face, cx - face.getWidth() / 2, cy - face.getHeight() / 2);
		leftPupilPos = new GPoint(face.getX() + FACE_WIDTH * 0.25, face.getY() + FACE_HEIGHT * 0.25);	// Starting position of left pupil
		rightPupilPos = new GPoint(face.getX() + FACE_WIDTH * 0.75, face.getY() + FACE_HEIGHT * 0.25);	// Starting position of right pupil
		leftPupil = new GBall(PUPIL_RADIUS, leftPupilPos);
		rightPupil = new GBall(PUPIL_RADIUS, rightPupilPos);
		add(leftPupil);
		add(rightPupil);
		addMouseListeners();
	}

	/* Call on mouse move to track the pupils to mouse pointer position. */
	public void mouseMoved(MouseEvent e) {
		GPoint leftEye = getUnitVector(leftPupilPos, e.getX(), e.getY());
		GPoint rightEye = getUnitVector(rightPupilPos, e.getX(), e.getY());
		leftPupil.setLocation(leftPupilPos.getX() + leftEye.getX() * PUPIL_DISTANCE, leftPupilPos.getY() + leftEye.getY() * PUPIL_DISTANCE);
		rightPupil.setLocation(rightPupilPos.getX() + rightEye.getX() * PUPIL_DISTANCE, rightPupilPos.getY() + rightEye.getY() * PUPIL_DISTANCE);
	}
	
	/* 
	 * Math Formula from 
	 * http://stackoverflow.com/questions/5602759/drawing-line-from-fixed-point-50px-towards-mouse-position-java 
	 */
	private GPoint getUnitVector(GPoint StartPos, double mouseX, double mouseY) {
		double dirX = mouseX - StartPos.getX();
		double dirY = mouseY - StartPos.getY();
		double length = Math.sqrt(dirX * dirX + dirY * dirY);
		dirX = dirX / length;
		dirY = dirY / length;
		GPoint point = new GPoint(dirX, dirY);
		return point;
	}

	private GPoint leftPupilPos, rightPupilPos;
	private GBall leftPupil, rightPupil;
}
