package ds_algo_assignment.week_3;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints  {

    private LineSegment[] segments;


//    public BruteCollinearPoints(Point[] points) {
//        checkDuplicatedEntries(points);
//        ArrayList<LineSegment> foundSegments = new ArrayList<>();
//
//        Point[] pointsCopy = Arrays.copyOf(points, points.length);
//        Arrays.sort(pointsCopy);
//
//        for (int p = 0; p < pointsCopy.length - 3; p++) {
//            for (int q = p + 1; q < pointsCopy.length - 2; q++) {
//                for (int r = q + 1; r < pointsCopy.length - 1; r++) {
//                    for (int s = r + 1; s < pointsCopy.length; s++) {
//                        if (pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[r]) &&
//                                pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[s])
//                        ) {
//                            foundSegments.add(new LineSegment(pointsCopy[p], pointsCopy[s]));
//                        }
//                    }
//                }
//            }
//        }
//
//        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
//    }

    // finds all line segments containing 4 points
    private ArrayList<LineSegment> jSegments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {


        if (points == null)
            throw new NullPointerException();
        // and now show must go on )))

        Point[] jCopy = points.clone();
        Arrays.sort(jCopy);

        if (hasDuplicate(jCopy)) {
            throw new IllegalArgumentException("U have duplicate points");
        }

        for (int first = 0; first < jCopy.length - 3; first++) {
            for (int second = first + 1; second < jCopy.length - 2; second++) {
                double slopeFS = jCopy[first].slopeTo(jCopy[second]);
                for (int third = second + 1; third < jCopy.length - 1; third++) {
                    double slopeFT = jCopy[first].slopeTo(jCopy[third]);
                    if (slopeFS == slopeFT) {
                        for (int forth = third + 1; forth < jCopy.length; forth++) {
                            double slopeFF = jCopy[first].slopeTo(jCopy[forth]);
                            if (slopeFS == slopeFF) {
                                jSegments.add(new LineSegment(jCopy[first], jCopy[forth]));
                            }
                        }
                    }
                }

            }
        }
    }

    private boolean hasDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                return true;
            }
        }
        return false;

    }

//    public int numberOfSegments() {
//        return segments.length;
//    }
//
//    public LineSegment[] segments() {
//        return Arrays.copyOf(segments, numberOfSegments());
//    }


    // the number of line segments
    public int numberOfSegments() {
        return jSegments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return jSegments.toArray(new LineSegment[jSegments.size()]);
    }

//    private void checkDuplicatedEntries(Point[] points) {
//        for (int i = 0; i < points.length - 1; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                if (points[i].compareTo(points[j]) == 0) {
//                    throw new IllegalArgumentException("Duplicated entries in given points.");
//                }
//            }
//        }
//    }

}