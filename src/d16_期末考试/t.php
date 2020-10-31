<?php
/**
 * Created by IntelliJ IDEA.
 * User: dell
 * Date: 2020/6/26
 * Time: 10:25
 */

namespace d16_期末考试;


$depth = 10; $day = 0;$flag = 0;//0白天，1黑夜
while(true){
    if($flag == 0){
        $depth = $depth - 1;
        if($depth >= 0)
        $flag = 1;
    }else if($flag == 1){
        $depth = $depth - 2;
        if($depth >= 0)
        $flag = 0;
    }
    $day+=0.5;
    if($depth <= 0&&$flag == 1){
        break;
    }}
echo $day;

