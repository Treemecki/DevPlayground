package dev.treemecki.java.functional.recursion;

public class DataRepeater {

    public String create(final String data, final int iterationsLimit) {
        return buildData(data, iterationsLimit, "", 0).invoke();
    }

    private TailCall<String> buildData(final String data, final int iterationsLimit,
                                       final String output, final int iteration) {
        if (iteration == iterationsLimit) {
            return TailCalls.done(output);
        }
        return TailCalls.call(() -> buildData(data, iterationsLimit, (output + data), (iteration + 1)));
    }

}
