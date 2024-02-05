public class Validsequence{
    public static void main(String[] args) {
        String[] regiNumbers = {"2022bct042", "2026cse833", "2023bce459", "2003bme010"};

        int validCount = 0;
        int validSeqCount = 0;
        int validSubstringSeqCount = 0;
        int validCustomSeqCount = 0;

        for (String regNumber : regiNumbers) {
            String year = regNumber.substring(0, 4);
            String department = regNumber.substring(4, 7).toUpperCase();
            String sequence = regNumber.substring(7, 9);

            int yearValue = Integer.parseInt(year);

            if (yearValue > 2000 && yearValue < 2025 &&
                (department.equals("CSE") || department.equals("BIT") || department.equals("BCE") || department.equals("BME")) &&
                isValidSequence(sequence)) {
                System.out.println("Valid Registration Number: " + regNumber);
                validCount++;
            }

            if (isValidSequence(sequence)) {
                validSeqCount++;
            }

            if (isValidSequenceSubstring(sequence)) {
                validSubstringSeqCount++;
            }


            if (issequencefifty(sequence)) {
                validCustomSeqCount++;
            }
        }

        System.out.println("Count of valid registrations: " + validCount);
        System.out.println("Count of valid sequences (isValidSequence): " + validSeqCount);
        System.out.println("Count of valid sequences (isValidSequenceSubstring): " + validSubstringSeqCount);
        System.out.println("Count of valid sequences (issequencefifty): " + validCustomSeqCount);
    }

    private static boolean isValidSequence(String sequence) {
        try {
            int sequenceValue = Integer.parseInt(sequence);
            return sequenceValue >= 1 && sequenceValue <= 999;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidSequenceSubstring(String sequence) {
        try {
            int sequenceValue = Integer.parseInt(sequence);
            return sequence.length() == 2 && sequenceValue >= 1 && sequenceValue <= 50;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean issequencefifty(String sequence) {
        try {
            int sequenceC = Integer.parseInt(sequence);
            return sequenceC >= 1 && sequenceC <= 50;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

