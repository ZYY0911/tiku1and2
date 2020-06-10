package com.example.tiku1demo2.bean;

/**
 * Created by dell on 2019/9/18.
 */

public class s_sjfx {
    private String chepaihao,yuanyin;

    public s_sjfx(String chepaihao, String yuanyin) {
        this.chepaihao = chepaihao;
        this.yuanyin = yuanyin;
    }

    @Override
    public String toString() {
        return "s_clwz{" +
                "chepaihao='" + chepaihao + '\'' +
                ", yuanyin='" + yuanyin + '\'' +
                '}';
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao;
    }

    public String getYuanyin() {
        return yuanyin;
    }

    public void setYuanyin(String yuanyin) {
        this.yuanyin = yuanyin;
    }
}
