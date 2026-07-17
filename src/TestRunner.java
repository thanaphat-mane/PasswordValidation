// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) {
            pass++;
            System.out.println("  [PASS] " + name);
        } else {
            fail++;
            System.out.println("  [FAIL] " + name);
        }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea)
            System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12") == true);

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try {
            PasswordValidator.validate(null);
        } catch (IllegalArgumentException e) {
            threw = true;
        }
        check("null -> throws IllegalArgumentException", threw == true);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check("pw len = 8", PasswordValidator.validate("aA123456") == true);
        check("pw len < 8", PasswordValidator.validate("Abcde12") == false);
        check("pw len = 20", PasswordValidator.validate("Abcdefghijklmnop1234") == true);
        check("pw len > 20", PasswordValidator.validate("Abcdefghijklmnop12345") == false);
        check("Len 19 (Max - 1) valid", PasswordValidator.validate("Abcdefghijklmnop123") == true);
        check("Len 21 but has all requirements", PasswordValidator.validate("Abcdefghijklmnop1234!") == false);

        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
        check("pw no upper and digit", PasswordValidator.validate("asdwerfga") == false);

        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check("pw no lower and digit", PasswordValidator.validate("ADFSDVCK") == false);

        // TODO: R5 - ไม่มีตัวเลข -> false
        check("pw no num", PasswordValidator.validate("fjgdjfgJADLJFdfs)(") == false);

        // TODO: R6 - มีช่องว่าง -> false
        check("pw has space", PasswordValidator.validate("Abc def1") == false);
        ;

        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น
        check("pw has only special characters", PasswordValidator.validate("!@#$%^&*()") == false);
        check("pw has special characters", PasswordValidator.validate("As$45678") == true);
        check("pw has upper and digit", PasswordValidator.validate("ADF45678") == false);
        check("pw has lower and digit", PasswordValidator.validate("adf45678") == false);

        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
