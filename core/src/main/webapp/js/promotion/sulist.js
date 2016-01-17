$(function() {
  // 一条广告高亮显示
  $( ".table_list td" ).mouseover(function() {
    if(!$(this).parent().hasClass('nohover')) {
      $(this).parent().toggleClass( 'highlight' );
    }
  }).mouseout(function() {
    if(!$(this).parent().hasClass('nohover')) {
      $(this).parent().toggleClass( 'highlight' );
    }
  });
});
