# -*- coding: utf-8 -*-
data = [
    ['1'],
    ['2']
]


def copy_line(line_data, subscript=0):

    """
    in line_data tail add the data
    :param line_data: 待添加数据的行
    :param subscript: 待添加的数据的组成部分
    :return: 添加完成的行
    """
    newline = []
    for line in line_data:
        newline.append(line)
    way = 'D:\Feature\\'+line_data[subscript]+'_face.bin(jpg)'
    newline.append(way)
    return newline


def way_add(student_data):
    new_list = []
    for line in student_data:
        new_list.append(copy_line(line))
    return new_list


if __name__ == '__main__':
    print way_add(data)
                                                                                                                                                                                                                                                                                                                                                     