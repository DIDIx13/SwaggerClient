package ch.heg.ig.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Admin token
        // final String token = "yVjpJsBe3ic95NRCKRXLmwbAfL7KZ4VmpaC5iXDcHpnjFVFAbR69-7ftunnW9El49o2AoTeX08r7jZDqJUL9kEgNEGNgI42fFAMkh43p9ViXKAmkbQlLM6T7zfa7GNVhWM5iWGKp-Kh0Ozj6-VCbLx_Iq7ouIEY-n_RSzHI1-HIMYi4zBWa68bWkKdgFZhKgIxaTbquB5x4UucSC5ggZU_Vr4ZBrrMYlxctngQII_RM7FzMgpvtHrqGlSXM3iOBwoBusq6iCeuNyc8uLxeNO1VnOmc-3ZiNyt0TH4NAlYVEYuY4Q4BIThcoNVEta-mz9cXcFs2TuhBVt9ZaVXSinsxgRRuIXWXOIIcKqP9UDJACoh1BY0iC2cP_jMr9U2Dst";

        // Resp Achat token
        final String token = "OaBwmnJYmwP3OM69m9KorVu7BJNFPhe7YnJQ5YC_J1P_ZPBYJ4zmKyTPlGFG7lA_X_Eusden6TDpwALVH1_fQxQ4O2nj7QhEjlx-CJUoUg9rHczFxLFaXG86Xcv6W1zNZz98xIjXcOvO5iSGsTRdoPI20kgJ7kw-dlljuLV6baNc9YnmrmnXdGlzlvsEhsOq7xw1elZUQN_jwTV-W831o8qcvuQb_LKBmKOV1QNZ2hPWtYoreB70Nzt1xoTEJT55boqCCCDxMZ4PrY3ju4WEJb-2RkrX-eMOqQw98Zc012YQ0JChzp8-MXguQc5mZFtgq9YIdrWyid3zKU0HNvn-UZogbGM-YtaiSP_eJwzdfn2janIp6HAFrI5-eVL6rz61";

        // Secretaire token
        // final String token = "";

        // Collaborateur token
        // final String token = "9tHM6rFQL_HW-unz4qUSbOLg4jbi8B39YYGysLkbj9kZ6mfHJzrOPWUk5_GBKmR-q4f1Uf6gUusVVWMiOIJ9-W0Tgtdw3c_2UcFJj_n0qkqKophh6nySKOiSSxCZFtcTatpV2xp1kzT39X8_vdDOpd9DZJjP0S-HCZVx5feMEX2oqYWG5yH6txZzUBQM5gMQYGtgYNP7BaLMGqA1GJa6XFgbgtsNyrUbk3hsgTFnnQkmgxDnoZ-v7zZ9_dNUXKZT6hWMaqpRTuFVk6YXvXT1W_I7hoqcnWoXNArV0IfpH-Nr7oe2Mkqc7CU6MyBTZ2svKfij8dfX8H1J5E6qSDsg0AQ9r8ZiZh82VOoFzOGiO89atOt_4FM09ZBtS7iT7yuM";

        try {
            ApiClient apiClient = new ApiClient(token);
            String userDetails = apiClient.getCurrentUserDetails();
            System.out.println(userDetails);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
